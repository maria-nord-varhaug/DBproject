package models;

import java.sql.Connection;

public abstract class ActiveDomainObject {

    //Initializes the object by reading data from one or more tables.
    public abstract void initialize(Connection conn);

    //Refresh the object's contents from the database to ensure consistency.
    public abstract void refresh(Connection conn);

    //Save changes to the object's contents by inserting or updating.
    public abstract void save(Connection conn);

    //Issues queries and returns data
    public abstract void list(Connection conn);

}