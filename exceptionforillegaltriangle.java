public class exceptionforillegaltriangle extends Throwable {
    private String side;
    public exceptionforillegaltriangle(String side){
        this.side = side;
    }
    public String getaside(){return side;}
}