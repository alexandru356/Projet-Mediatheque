package controller;

import model.Document;

public class DocumentSelection {
	//singleton class
	private static Document docSelect;

	public static Document getSelectedDocument() {
		return docSelect;
	}

	public static void setSelectedDocument(Document document) {
		docSelect = document;
	}
}
