package server;
import java.io.*;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.List;



import org.jdom2.*;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.*;

public class RequirementReader {

	   static org.jdom2.Document document;
	   static Element racine;

	
	   public void readFile(){
		 //On cr�e une instance de SAXBuilder
		      SAXBuilder sxb = new SAXBuilder();
		      try
		      {
		         //On cr�e un nouveau document JDOM avec en argument le fichier XML
		         //Le parsing est termin� ;)
		         document = sxb.build(new File("./requirements_save.xml"));
		      }
		      catch(Exception e){}

		      //On initialise un nouvel �l�ment racine avec l'�l�ment racine du document.
		      racine = document.getRootElement();
		      afficheALL();
	   }
	   
	   static void afficheALL()
	   {
	      //On cr�e une List contenant tous les noeuds "etudiant" de l'Element racine
	      List listDesc = racine.getChildren("requirement");

	      //On cr�e un Iterator sur notre liste
	      Iterator i = (Iterator) listDesc.iterator();
	      
	      while(i.hasNext())
	      {
	         //On recr�e l'Element courant � chaque tour de boucle afin de
	         //pouvoir utiliser les m�thodes propres aux Element comme :
	         //s�lectionner un n�ud fils, modifier du texte, etc...
	         Element courant = (Element)i.next();
	         //On affiche le nom de l��l�ment courant
	         System.out.println(courant.getChild("description").getText());
	      }
	   }
	
}
