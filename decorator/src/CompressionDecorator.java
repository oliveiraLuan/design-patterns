import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

public class CompressionDecorator extends DataSourceDecorator{
    private int compressLevel = 6;

    public CompressionDecorator(DataSource source) {
        super(source);
    }

    public int getCompressLevel() {
        return compressLevel;
    }

    public void setCompressLevel(int compressLevel) {
        this.compressLevel = compressLevel;
    }

    @Override
    public void writeData(String data) {
        super.writeData(compress(data));
    }

    @Override
    public String readData() {
        return decompress(super.readData());
    }

    private String compress(String stringData){
        byte[] data = stringData.getBytes();
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
            DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, new Deflater(compressLevel));
            deflaterOutputStream.write(data);
            deflaterOutputStream.close();
            byteArrayOutputStream.close();
            return Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray());
        } catch (IOException exception){
            return null;
        }
    }
    private String decompress(String stringData){
        byte[] data = Base64.getDecoder().decode(stringData);
        try {
            InputStream in = new ByteArrayInputStream(data);
            InflaterInputStream inflaterInputStream = new InflaterInputStream(in);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
            int b;
            while((b = inflaterInputStream.read()) != -1)
                byteArrayOutputStream.write(b);
            in.close();
            inflaterInputStream.close();
            byteArrayOutputStream.close();
            return new String(byteArrayOutputStream.toByteArray());
        }   catch (IOException e){
            return null;
        }
    }
}
