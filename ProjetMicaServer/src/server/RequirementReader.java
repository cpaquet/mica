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
		 //On crée une instance de SAXBuilder
		      SAXBuilder sxb = new SAXBuilder();
		      try
		      {
		         //On crée un nouveau document JDOM avec en argument le fichier XML
		         //Le parsing est terminé ;)
		         document = sxb.build(new File("./requirements_save.xml"));
		      }
		      catch(Exception e){}

		      //On initialise un nouvel élément racine avec l'élément racine du document.
		      racine = document.getRootElement();
		      afficheALL();
	   }
	   
	   static void afficheALL()
	   {
	      //On crée une List contenant tous les noeuds "etudiant" de l'Element racine
	      List listDesc = racine.getChildren("requirement");

	      //On crée un Iterator sur notre liste
	      Iterator i = (Iterator) listDesc.iterator();
	      
	      while(i.hasNext())
	      {
	         //On recrée l'Element courant à chaque tour de boucle afin de
	         //pouvoir utiliser les méthodes propres aux Element comme :
	         //sélectionner un nœud fils, modifier du texte, etc...
	         Element courant = (Element)i.next();
	         //On affiche le nom de l’élément courant
	         System.out.println(courant.getChild("description").getText());
	      }
	   }
	
}
