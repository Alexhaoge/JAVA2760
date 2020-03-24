public class ServerTimedOutException extends Exception{
    private int port;
    private static final long serialVersionUID = 1L;
    public ServerTimedOutException(String message, int port){
        super(message);
        this.port = port;
    }
    public int getPort() {
        return port;
    }
    /*public static void main(String[] args){
        ServerTimedOutException e = new ServerTimedOutException("a", 11);
        System.out.println(e.getPort());
    }*/
}