package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Document {


	private StringProperty numDoc;
	private StringProperty titre;
	private IntegerProperty nbPrets;
	private ObjectProperty<LocalDate> datePublication;
	private BooleanProperty estEmprunte;
	private StringProperty nomEmprunteur;

	public Document(String numDoc, String titre, int nbPrets, String datePublication) {
		this.numDoc = new SimpleStringProperty(numDoc);
		this.titre = new SimpleStringProperty(titre);
		this.nbPrets = new SimpleIntegerProperty(nbPrets);
		this.datePublication = new SimpleObjectProperty<>(LocalDate.parse(datePublication));
		this.estEmprunte = new SimpleBooleanProperty(false);
		this.nomEmprunteur = new SimpleStringProperty("testEmprunteur");
	}

	public BooleanProperty estEmprunteProperty() {
		return this.estEmprunte;
	}

	public boolean isEstEmprunte() {
		return this.estEmprunte.get();
	}

	public void setEstEmprunte(boolean estEmprunte) {
		this.estEmprunte.set(estEmprunte);
	}

	public StringProperty etatProperty() {
		return new SimpleStringProperty(isEstEmprunte() ? "Non Disponible" : "Disponible");
	}
	
	public final StringProperty titreProperty() {
		return this.titre;
	}


	public final String getTitre() {
		return this.titreProperty().get();
	}


	public final void setTitre(final String titre) {
		this.titreProperty().set(titre);
	}


	public final IntegerProperty nbPretsProperty() {
		return this.nbPrets;
	}


	public final int getNbPrets() {
		return this.nbPretsProperty().get();
	}


	public final void setNbPrets(final int nbPrets) {
		this.nbPretsProperty().set(nbPrets);
	}

	public final StringProperty datePublicationFormattedProperty() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		return new SimpleStringProperty(getDatePublication().format(formatter));
	}


	public final LocalDate getDatePublication() {
		return this.datePublication.get();
	}

	public final void setDatePublication(final LocalDate datePublication) {
		this.datePublication.set(datePublication);
	}


	public final StringProperty numDocProperty() {
		return this.numDoc;
	}




	public final String getNumDoc() {
		return this.numDocProperty().get();
	}




	public final void setNumDoc(final String numDoc) {
		this.numDocProperty().set(numDoc);
	}

	public final StringProperty nomEmprunteurProperty() {
		return this.nomEmprunteur;
	}
	

	public final String getNomEmprunteur() {
		return this.nomEmprunteurProperty().get();
	}
	

	public final void setNomEmprunteur(final String nomEmprunteur) {
		this.nomEmprunteurProperty().set(nomEmprunteur);
	}
	

}


