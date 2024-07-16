package practice.hospital;

public class Hospital {

    public static float[] generatePatientsTemperatures(int patientsCount) {

        float[] temperaturePatients = new float[patientsCount];
        float min = 32.0f;
        float max = 40.0f;
        for (int i = 0; i < patientsCount; i++) {
            temperaturePatients[i] = (float) (Math.random() * ((max - min)) + min);
            temperaturePatients[i] = (float) Math.round(temperaturePatients[i] * 10) / 10;
        }
        return temperaturePatients;
    }

    public static String getReport(float[] temperatureData) {
        /*
        TODO: Напишите код, который выводит среднюю температуру по больнице,количество здоровых пациентов,
            а также температуры всех пациентов.
            Округлите среднюю температуру с помощью Math.round до 2 знаков после запятой,
            а температуры каждого пациента до 1 знака после запятой
        */

        float averageTemp = 0;
        float sumTemp = 0;
        int healthPeople = 0;
        StringBuilder eachTemp = new StringBuilder();


        for (int i = 0; i < temperatureData.length; i++) {
            sumTemp = sumTemp + temperatureData[i];
            eachTemp.append(Math.round(temperatureData[i] * 10f) / 10f).append(" ");


        }
        averageTemp = sumTemp / temperatureData.length;
        averageTemp = Math.round(averageTemp * 100);
        averageTemp = averageTemp / 100;

        for (float temperature : temperatureData) {
            if (temperature >= 36.2f && temperature <= 36.9f) {
                healthPeople++;
            }
        }


        String report =
                "Температуры пациентов: " + eachTemp.toString().strip() +
                        "\nСредняя температура: " + averageTemp +
                        "\nКоличество здоровых: " + healthPeople;

        return report;
    }
}
