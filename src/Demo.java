import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Demo {
    private final static String UR ="https://jsonplaceholder.typicode.com/users";
    private final static String URid= "https://jsonplaceholder.typicode.com/users/2";
    private final static String URname= "https://jsonplaceholder.typicode.com/users";
    private final static String URtask = "https://jsonplaceholder.typicode.com/users/1/todos";
    private final static String URcoments = "https://jsonplaceholder.typicode.com/users/1/posts";

    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {

        User user = new User();
        user.setId(9);
        user.setName("Delphine");
        user.setUsername("Delphine");

        final User createdUser = Utilki.sendPost(URI.create(UR), user);

        System.out.println(createdUser);

        String InformationAllCustomersById = Utilki.sendGet(URI.create(String.format("%s?id=%d", URid, createdUser.getId())));
        System.out.println("All Customers By Id = " + InformationAllCustomersById);

        String InformationAllCustomersByName = Utilki.sendGet(URI.create(String.format("%s?username=%s", URname, createdUser.getUsername())));
        System.out.println("Customers By Name = " + InformationAllCustomersByName);

        String InformationAllCustomers = Utilki.sendGet(URI.create(UR));
        System.out.println("All Customers = " + InformationAllCustomers);

        int InformStatusDel = Utilki.sendDel(URI.create(URid));
        System.out.println(InformStatusDel);

        Utilki.GetTask(URI.create(URtask));
        Utilki.GetComets(URI.create(URcoments));
    }
}
