import java.io.*;
import javafx.scene.paint.*;

public class Niveau {

	private int[] taille; //[largeur, longueur]
	//private ArrayList<Brique> briques; //liste des coordonnées et couleurs des briques

	public Niveau(){
		taille=new int[2];
	//	briques=new ArrayList();

	}

	public boolean chargement(String path){ //chemin du fichier niveau.txt
		try{
			InputStream ips= new FileInputStream(path);
			InputStreamReader ipsr= new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;

			ligne=br.readLine(); //dimensions du niveau
			String[] t=ligne.split(" x ");
			try{
				taille[0]=Integer.parseInt(t[0]);
				taille[1]=Integer.parseInt(t[1]);
				System.out.println("("+taille[0]+", "+taille[1]+")");
			}
			catch(NumberFormatException e){
				System.out.println("les dimensions ne sont pas bonnes !");
				return false;
			}

			while((ligne=br.readLine())!=null){ //donnees sur chaque brique
				t=ligne.split(" & ");  //[dim NW, dim SE, couleur]
				t[0]=t[0].replace("(","");
				t[0]=t[0].replace(")","");
				t[1]=t[1].replace("(","");
				t[1]=t[1].replace(")","");
				try{
					String [] coord=t[0].split(", ");
					int x1=Integer.parseInt(coord[0]);
					int y1=Integer.parseInt(coord[1]);
					coord=t[1].split(", ");
					int x2=Integer.parseInt(coord[0]);
					int y2=Integer.parseInt(coord[1]);
					if(x1>x2 || y1>y2){
						return false;
					}
	//				Brique b=new Brique(x1,y1,Math.abs(x1-x2),Math.abs(y1-y2));
					Color color = Color.valueOf(t[2]);
					System.out.println("coordonnées NW : ("+x1+", "+y1+") ; coordonnées SE : ("+x2+", "+y2+") ; couleur : "+color.toString());
	//				b.setColor(color);
	//				briques.add(b);
				}
				catch(NumberFormatException e){
					System.out.println("les coordonnées ne sont pas bonnes !");
					return false;
				}	
			}
			br.close();
		}
		catch(Exception e){
			System.out.println("erreur lors de la recuperation du niveau !");
			return false;
		}
		return true;
	}

	public static void main(String[]args){
		Niveau n = new Niveau();
		System.out.println(n.chargement("niveau1.txt"));
	}

}
