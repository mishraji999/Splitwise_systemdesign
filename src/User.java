public class User {
    private String name;
    private String emailid;
    private int id;

    public User( int id, String name, String emailid){
        setId(id);
        setName(name);
        setEmailId(emailid);
    }

    public void setName(String name){
        if(name.matches("[a-zA-Z]+") && !name.isEmpty()){
            this.name = name;
        }else{
            System.out.println("Provide a valid name");
        }
    }

    public String getName() {
        return name;
    }

    public void setEmailId(String emailid){
        if(emailid.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            this.emailid = emailid;
        }else{
            System.out.println("Provide a valid email id");
        }
    }

    public String getEmailId() {
        return emailid;
    }

    public void setId(int id){
        if(id > 0){
            this.id = id;
        }
    }

    public int getId() {
        return id;
    }


    @Override
    public String toString(){
       return name + " " + id + " " + emailid;
    }


}
