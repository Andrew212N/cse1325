package person;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Customer extends Person
{
    public Customer(String name, String phone)
    {
        super(name, phone);
    }
    
    public Customer(BufferedReader br) throws IOException {
        this.name = br.readLine();
        this.phone = br.readLine();
    }
    
    public void save(BufferedWriter bw) throws IOException {
        bw.write(name + '\n');
        bw.write(phone + '\n');
    }
}
