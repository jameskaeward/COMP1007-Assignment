/**
 * FILE:        Astronaut.java
 * <p>
 * UNIT:        COMP1007
 * <p>
 * REFERENCE:   https://www.oracle.com/technetwork/java/javase/documentation/index-137868.html
 * <p>
 * COMMENTS:    Represents an Astronaut.
 * <p>
 * REQUIRES:    None.
 * <p>
 * Last Mod:    14th April 2025
 * <p>
 * @author      Rungpipol Kaew-ard
 */
public class Astronaut
{
    private String name;
    private String role;
    private String nationality;
    private int age;

    /**
     * Default constructor.
     */
    public Astronaut()
    {
        this.name = "Liu Wong";
        this.age = 30;
        this.role = "Commander";
        this.nationality = "China";
    }

    /**
     * Copy constructor.
     * @param astronaut
     */
    public Astronaut(Astronaut astronaut)
    {
        this.name = astronaut.getName();
        this.age = astronaut.getAge();
        this.role = astronaut.getRole();
        this.nationality = astronaut.getNationality();
    }

    /**
     * Creates a new representation of an astronaut.
     * @param name The first and last name of the astronaut.
     * @param age The age of the astronaut in years.
     * @param role The role of the astronaut.
     * @param nationality The astronaut's nationality.
     */
    public Astronaut(String name, int age, String role, String nationality)
    {
        this.name = name;
        this.age = age;
        this.role = role;
        this.nationality = nationality;
    }

    /**
     * Checks if input astronat is equal to this astronaut.
     * @param astronaut
     * @return <code>true</code> if the astronaut is equal, otherwise <code>false</code>.
     */
    public boolean equals(Astronaut astronaut)
    {
        boolean isEqual = false;

        if (this.age == astronaut.getAge())
        {
            if (this.name == astronaut.getName())
            {
                if (this.nationality == astronaut.getNationality())
                {
                    if (this.role == astronaut.getRole())
                    {
                        isEqual = true;
                    }
                }
            }
        }

        return isEqual;
    }

    /**
     * Gets the name of the Astronaut.
     * @return The astronaut's name.
     */
    public String getName()
    {
        return this.name; 
    }
    
    /**
     * Gets the nationality of the Astronaut
     * @return The astronaut's nationality.
     */
    public String getNationality()
    {
        return this.nationality; 
    }

    /**
     * Gets the role of the Astronaut.
     * @return The astronaut's role.
     */
    public String getRole()
    {
        return this.role;
    }

    /**
     * Gets the age of the Astronaut.
     * @return The astronaut's age.
     */
    public int getAge()
    {
        return this.age;
    }
}