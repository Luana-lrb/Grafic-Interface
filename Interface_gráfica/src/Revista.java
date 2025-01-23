public class Revista extends Publicacao{
    private String org;
    private String vol;
    private String nro;

    public Revista(String titulo, String ano, String org, String vol, String nro) {
        super(titulo, ano);
        this.org = org;
        this.vol = vol;
        this.nro = nro;
    }

    public String getOrg() {return org;}

    public void setOrg(String org) {this.org = org;}

    public String getVol() {return vol;}

    public void setVol(String vol) {this.vol = vol;}

    public String getNro() {return nro;}

    public void setNro(String nro) {this.nro = nro;}

    @Override
    public String toString() {
        return "Revista:" + super.toString()+
                " " + org +
                ", " + vol +
                ", " + nro ;
    }
}
