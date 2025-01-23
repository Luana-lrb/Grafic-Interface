public class Publicacao {
    private String titulo;
    private String ano;

    public Publicacao(String titulo, String ano) {
        this.titulo = titulo;
        this.ano = ano;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAno() {return ano;}

    public void setAno(String ano) {this.ano = ano;}

    @Override
    public String toString() {
        return " " + titulo +
                ", " + ano + ",";
    }
}
