public class Clients {

    private String name;
    private String email;
    private String nomer;

    public Clients(String name, String gmail, String nomer){
        this.name = name;
        this.email = gmail;
        this.nomer = nomer;
    }


    @Override
    public String toString() {
        return "Clients{" +
                "name='" + name + '\'' +
                ", gmail='" + email + '\'' +
                ", nomer='" + nomer + '\'' +
                '}';
    }
}
