package Hibernate.Utilidad;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Utilidad {
    private static StandardServiceRegistry standardServiceRegistry;
    private static SessionFactory sessionFactory;
    static {
        try {
            standardServiceRegistry = new StandardServiceRegistryBuilder().configure("Resources/properties.xml").build();
            MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
            Metadata metadata = metadataSources.getMetadataBuilder().build();
            sessionFactory = metadata.getSessionFactoryBuilder().build();

        } catch (Exception e) {
            if (standardServiceRegistry != null)
            {
                StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
            }
        }
    }

    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }
}
