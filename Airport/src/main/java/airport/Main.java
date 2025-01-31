package airport;

import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

    public static long findCountAircraftWithModelAirbus(Airport airport, String model) {
        //TODO Метод должен вернуть количество самолетов указанной модели.
        // подходят те самолеты, у которых name начинается со строки model
        return airport.getAllAircrafts().stream()
                .filter(aircraft -> aircraft.getModel().startsWith(model))
                .count();

    }




    public static Map<String, Integer> findMapCountParkedAircraftByTerminalName(Airport airport) {
        //TODO Метод должен вернуть словарь с количеством припаркованных самолетов в каждом терминале.
        return airport.getTerminals().stream()
                .collect(Collectors.toMap(
                        Terminal::getName,
                        terminal -> terminal.getParkedAircrafts().size()
                ));

    }

    public static List<Flight> findFlightsLeavingInTheNextHours(Airport airport, int hours) {
        //TODO Метод должен вернуть список отправляющихся рейсов в ближайшее количество часов.

        LocalDateTime currentTime = LocalDateTime.now(ZoneId.of("Europe/Paris"));
        Instant currentInstant = currentTime.atZone(ZoneId.of("Europe/Paris")).toInstant();
        return airport.getTerminals().stream()
                .flatMap(terminal -> terminal.getFlights().stream())
                .filter(flight -> flight.getType().equals(Flight.Type.DEPARTURE))
                .filter(flight -> flight.getDate().isAfter(currentTime.atZone(ZoneId.of("Europe/Paris")) .toInstant()))
                .filter(flight -> Duration.between(currentInstant, flight.getDate()).toHours() <= hours-1)
                .collect(Collectors.toList());


    }





    public static Optional<Flight> findFirstFlightArriveToTerminal(Airport airport, String terminalName) {
        //TODO Найти ближайший прилет в указанный терминал.

        LocalDateTime currentTime = LocalDateTime.now(ZoneId.of("Europe/Paris"));
        Instant currentInstant = currentTime.atZone(ZoneId.of("Europe/Paris")).toInstant();

        return airport.getTerminals().stream()
                .filter(terminal -> terminal.getName().equals(terminalName))
                .flatMap(terminal -> terminal.getFlights().stream())
                .filter(flight -> flight.getType().equals(Flight.Type.ARRIVAL))
                .filter(flight -> flight.getDate().isAfter(currentInstant))
                .min(Comparator.comparing(Flight::getDate));

    }

}