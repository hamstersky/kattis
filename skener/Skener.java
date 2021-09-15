public class Skener {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int R = io.getInt();
        int C = io.getInt();
        int Zr = io.getInt();
        int Zc = io.getInt();
    
        String[][] article = new String[R][C];
        String[][] newArticle = new String[R*Zr][C];
        for (int i = 0; i < R; i++) {
            article[i] = io.getWord().split("");
            for (int j = 0; j < C; j++) {
                newArticle[i][j] = article[i][j].repeat(Zc);
            }
            for (int k = 0; k < Zr; k++) {
                System.out.println(String.join("", newArticle[i]));
            }
        }
    }
}