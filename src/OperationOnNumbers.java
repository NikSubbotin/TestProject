import java.io.IOException;

public interface OperationOnNumbers {

    void help() throws IOException;

    void init_array(int[] dataIn);

    void print(String typeList);

    void clear(String typeList);

    void merge();

    void anyMore();
}
