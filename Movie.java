public class Movie implements TreeNode{
    private String title;
    private CustomDate date;
    private String firstName,lastName;
    private BST castList;

    public Movie(String title, CustomDate date, String firstName, String lastName) {
        this.title = title;
        this.date = date;
        this.firstName = firstName;
        this.lastName = lastName;
        castList = new BST();
    }

    @Override
    public boolean Compare(TreeNode t) {
        if (t instanceof Movie){
            return ((Movie) t).date.getYear()> date.getYear();
        }
        else return false;
    }
    public void addActor(Cast cast){
        castList.addNode(cast);
    }
    public BST getCastList() {
        return castList;
    }

    public void setCastList(BST castList) {
        this.castList = castList;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CustomDate getDate() {
        return date;
    }

    public void setDate(CustomDate date) {
        this.date = date;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @Override
    public String toString() {
        return String.format("%s, %d, %s %s",getTitle(),getDate().getYear(),getFirstName(),getLastName());
    }
}
class Cast implements TreeNode{
    public Cast(String firstName, String lastName, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    private String firstName;
    private String lastName;
    private String role;

    @Override
    public boolean Compare(TreeNode t) {
        if (t instanceof Cast){
           return ((Cast) t).firstName.compareTo(firstName)>0;
        }
        else return false;
    }

    @Override
    public String toString() {
        return "Cast{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
class CustomDate{
    private int day;
    private int month;

    public CustomDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    private int year;

    @Override
    public String toString() {
        return "CustomDate{" +
                "day=" + day +
                ", month=" + month +
                ", year=" + year +
                '}';
    }
}
