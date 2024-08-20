public class Product {
    private String ID = "";
    private String name = "";
    private String description = "";
    private double cost = 0.0;

    private static int IDSeed = 1;

    public Product (String ID, String name, String description, double cost){ //Updated Constructor.
        this.setID(ID);
        this.setName(name);
        this.setDescription(description);
        this.setCost(cost);
    }

    public Product (String name, String description, double cost){ //Updated Constructor.
        this.ID = generatorID(); // Won't let the user create an ID, rather it will be assigned.
        this.setName(name);
        this.setDescription(description);
        this.setCost(cost);
    }

    //Getter and Setter Methods for "ID".
    public String getID (){
        return ID;
    }
    public void setID(String ID){
        this.ID = ID;
    }


    /**
     * Computer generates a 6 char ID that increments after every use of this method.
     * @return - Returns a 6 char ID
     */
    private String generatorID(){
        String newID = "" + IDSeed; //Starts at 1.

        while (newID.length() < 6){
            newID = "0" + newID;
        }
        IDSeed++;

        return newID;
    }


    //Getter and Setter Methods for "name".

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
    //Getter and Setter Methods for "description".
    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }
    //Getter and Setter Methods for "cost".
    public double getCost(){
        return cost;
    }

    public void setCost(double cost){
        this.cost = cost;
    }
    //Additional Methods
    public String fullDescription(){
        String info;
        info = getName() + " - " + getDescription();

        return info;
    }

    public String toCSVDataRecord(){
        String personData = "";

        personData = getID() + "," + getName() + "," + getDescription() + "," + getCost();
        return personData;
    }

    @Override
    public String toString() {
        return "Product{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                '}';
    }
}
