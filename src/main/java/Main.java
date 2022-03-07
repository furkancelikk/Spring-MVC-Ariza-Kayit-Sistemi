/**
 * @author furkancelik
 */
public class Main {

    /**
     * Kişi adı
     */
    private String name;

    /**
     * Kişi soyadı
     */
    private String surname;

    /**
     * Main sınıfı yapıcı fonksiyonu
     * @param name Kişi adı
     * @param surname Kişi soyadı
     */
    public Main(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    /**
     * Kişinin ad ve soyadını döndüren metod
     * @return Ad ve soyad
     */
    public String getKisi(){
        return this.name + ' ' + this.surname;
    }
}
