import java.util.Scanner;

public class Main {

    static Scanner scan = new Scanner (System.in);


    public static void main(String[] args) {

        // kahve seçimi aşaması

        // Kullaniciya hangi kahveyi istedigi sorulur ve kahve secenekleri yazdirilir.

        menuyuYazdir();

        // Kullaniciya hangi kahveyi sectigi sorulur ve alinan cevap bir degiskende tutulur.

        String kahveSecim= kahveSecimiYap();

        // Kullanicinin sectigi kahveye gore konsola bilgilendirme mesaji yazdirilir.

        System.out.println(kahveSecim + " hazirlaniyor");

        // Sut ekleme asamasi

        // Kullaniciya sut isteyip istemedigi sorulur ve cevap bir String degiskende saklanir.

        sutEkle();

        // Seker ekleme asamasi

        // Kullaniciya seker isteyip istemedigi sorulur ve yanit evet ise kac seker istedigi sorularak konsola
        // '{sekerSayisi} seker ekleniyor'

        sekerEkle();

        // Boy secim asamasi

        // Kullaniciya secilebilecek boy bilgileri yazdirilir ve kullanicidan secim yapmasi beklenir
        boySecimiYap();

    }

    private static String boySecimiYap() {
        System.out.println("***************************************************\n\nHangi boyutta olsun? (Büyük boy - orta boy - küçük boy olarak giriniz.)\n\n***************************************************");
        String boySecim = scan.nextLine();

        switch (boySecim.toLowerCase()){
            case "buyuk boy":
            case "orta boy":
            case "kucuk boy":
                System.out.println("Kahveniz " + boySecim + " hazirlaniyor");
                break;

            default:
                System.out.println("Yanlis giris yaptiniz lutfen dogru boy giriniz...");
                boySecimiYap();
                break;
        }
        return boySecim;
    }

    private static void sekerEkle() {
        System.out.println("***************************************************\n\nSeker eklememizi ister misiniz ? (Evet veya Hayır olarak cevaplayınız):\n\n***************************************************");
        String sekerSecim= scan.nextLine();

        if (sekerSecim.equalsIgnoreCase("evet")){
            System.out.println("***************************************************\n\nKac seker eklememizi istersiniz?\n\n***************************************************");
            int sekerSayisi=scan.nextInt();
            System.out.println();
            if (sekerSayisi>0 ){
                System.out.println(sekerSayisi + " şeker ekleniyor");
            } else {
                System.out.println("hatalı giriş yaptınız, lütfen doğru girdi yapınız");
                sekerEkle();
            }
        } else if (sekerSecim.equalsIgnoreCase("hayır")){
            System.out.println("kahvenize şeker eklenmiyor");
        } else {
            System.out.println("Hatalı bir giriş yaptınız\n lütfen evet veya hayır yazınız");
        }
    }

    private static void sutEkle() {
        System.out.println("***************************************************\n\nSüt eklememizi ister misiniz ? (Evet veya Hayır olarak cevaplayınız):\n\n***************************************************");
        String sutSecim = scan.nextLine();

        if (sutSecim.equalsIgnoreCase("evet")){
            System.out.println("\n süt ekleniyor");
        } else if (sutSecim.equalsIgnoreCase("hayır")) {
            System.out.println("\n kahvenize süt eklenmiyor");
        } else {
            System.out.println(" Yanlış bir giriş yaptınız.\n Lütfen evet veya hayır yazınız");
            sutEkle();
        }
    }

    private static String kahveSecimiYap() {
        // Oyle bir method gelistir ki kullanici dogru secim yapana kadar methoddan cikamasin

        while (true){

            String secim = scan.nextLine();

            // Bu degiskenim eger kabul edilebilir bir girdi ise methoddan cikilir, degil ise menu tekrardan yazdirilarak dongunun basina donulur.
            if((secim.equalsIgnoreCase("türk kahvesi")) ||
                    (secim.equalsIgnoreCase("filtre kahve")) ||
                    (secim.equalsIgnoreCase("espresso"))){
                return secim;
            } else {
                System.out.println("Yanlış bir seçim yaptınız.. Lütfen doğru bir giriş yapınız");
                menuyuYazdir();
            }

        }

    }

    private static void menuyuYazdir() {
        System.out.println("*******************************************\n");
        System.out.println("Hangi kahveyi istersiniz?");
        System.out.println("1. Turk Kahvesi");
        System.out.println("2. Filtre Kahve");
        System.out.println("3. Espresso");
        System.out.println("\n*******************************************\n\n");
    }
}

