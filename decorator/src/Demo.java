public class Demo {
    public static void main(String[] args) {
        String salaryRecords = "Name,Salary\nDeborah Morgan, 5000\nDexter Morgan,10000";
        DataSourceDecorator encoded = new CompressionDecorator(new EncryptionDecorator(new FileDataSource("out/output.txt")));
        encoded.writeData(salaryRecords);
        DataSource plain = new FileDataSource("out/output.txt");
        System.out.println("- INPUT -------------");
        System.out.println(salaryRecords);
        System.out.println("- ENCODED -------------");
        System.out.println(plain.readData());
        System.out.println("- DECODED -------------");
        System.out.println(encoded.readData());
    }
}
