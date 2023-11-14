package pruebas;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class General {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Obtener la sesión de Hibernate
        SessionFactory sessionFactory = Conex.getSessionFactory();
        Session session = sessionFactory.openSession();

        // Iniciar una transacción
        Transaction transaction = session.beginTransaction();

        try {
            // Crear un objeto de entidad y establecer sus atributos
            User usuario = new User();
            usuario.setNombre("Adolfo");
            usuario.setApellido("Profesor");

            // Persistir el objeto en la base de datos
            session.save(usuario);

            // Confirmar la transacción
            transaction.commit();

            System.out.println("Datos ingresados exitosamente en la tabla usuario.");
        } catch (Exception e) {
            // Manejar excepciones, hacer rollback si es necesario
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            // Cerrar la sesión de Hibernate
            session.close();
            sessionFactory.close();
        }

	}

}
