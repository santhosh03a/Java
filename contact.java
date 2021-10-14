public class contact {
    private String firstname;
    private  String lastname;
    private String phoneNumber;

    public contact(String firstname,String lastname,String phoneNumber){
        this.firstname=firstname;
        this.lastname=lastname;
        this.phoneNumber=phoneNumber;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void validatefirstname(){
        if(this.firstname==null){
            throw new RuntimeException("first name cannot be null");
        }
    }
    public void validatelastname(){
        if(this.lastname==null){
            throw new RuntimeException("last name cannot be null");
        }
    }
    public void validatephonenumber(){
        if(this.phoneNumber==null){
            throw new RuntimeException("phonenumber should not be null");
        }
        if(this.phoneNumber.length()!=10){
            throw new RuntimeException("phonenumber length should be 10");
        }
        if(!this.phoneNumber.matches("\\d+")){ //(\\d+ regular expression to check whether the no is digits)
            throw new RuntimeException("the phoneNumber should be digits");
        }
        if(!this.phoneNumber.startsWith("0")){
            throw new RuntimeException("phone number should start with 0");
        }
    }
}
