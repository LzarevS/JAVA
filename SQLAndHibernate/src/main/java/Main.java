import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure();
        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            // Получаем список объектов PurchaseList из базы данных
            List<PurchaseList> purchaseLists = session.createQuery("FROM PurchaseList").getResultList();

            // Для каждого объекта PurchaseList создаем объект LinkedPurchaseList
            for (PurchaseList purchaseList : purchaseLists) {
                LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList();
                // Устанавливаем значения studentId и courseId на основе объекта PurchaseList
                linkedPurchaseList.setStudentId(purchaseList.getStudent().getId());
                linkedPurchaseList.setCourseId(purchaseList.getCourse().getId());
                // Сохраняем объект LinkedPurchaseList в базе данных
                session.save(linkedPurchaseList);
            }

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
