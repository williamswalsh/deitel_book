package exceptions;

public class ExceptionTesting {
    public static void main(String[] args) {
        try {
            f1();
        }catch(Exception e){
            e.getMessage();
            e.printStackTrace();
            StackTraceElement[] traceElements = e.getStackTrace();

            System.out.printf("Class\t\t\t\tFile\t\t\t\t\tLine Method\n");
            for (StackTraceElement element: traceElements) {
                System.out.printf("%s\t",element.getClassName());
                System.out.printf("%s\t",element.getFileName());
                System.out.printf("%s\t",element.getLineNumber());
                System.out.printf("%s\n",element.getMethodName());
            }
        }
    }

    public static void f1() throws Exception{
        f2();
    }
    public static void f2() throws Exception{
        f3();
    }
    public static void f3() throws Exception{
        throw new Exception("Exception thrown in f3");
    }
}
