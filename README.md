# JavaFX MediaTheque

This project is a **MediaTheque application** built using JavaFX. The application serves as a digital library for managing media files, such as books, movies, and music. It allows users to organize, search, and display their media collection through an intuitive graphical interface.

## Features

- **Media Management**: Add, edit, and remove media items (e.g., books, movies, music).
- **Search Functionality**: Search for items by title, genre, or other attributes.
- **Category Organization**: Organize media by categories for better management.
- **Interactive GUI**: User-friendly interface built with JavaFX.

## Technologies Used

- **JavaFX**: For building the graphical user interface.
- **Java**: Core programming language for the backend logic.
- **FXML**: For defining the UI layout.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 11 or higher installed.
- JavaFX SDK installed and configured.

### Installation

1. Clone the repository:

2. Set up your development environment:
   - Ensure JavaFX SDK is included in your project's libraries.
   - Configure your IDE (e.g., IntelliJ IDEA or Eclipse) to recognize the JavaFX module.

3. Build and run the project:
   - Using your IDE's build tools or directly via the command line.
   - Example (using Maven):
     ```bash
     mvn clean javafx:run
     ```

### Usage

1. Launch the application.
2. Use the "Add Media" button to add new items to your library.
3. Use the search bar to filter and find specific media items.
4. Use the category tabs to browse items by type.
5. Save your library to a file or database for future use.

## File Structure

- `src/main/java`: Contains the source code for the application.
  - `controller`: Handles UI interactions and business logic.
  - `model`: Defines the data models for media items.
  - `view`: Contains the FXML files for the UI layout.
- `src/main/resources`: Includes FXML layouts and assets (images, stylesheets).



## Acknowledgments

- Thanks to the JavaFX community for their support and documentation.
- Inspired by traditional media library management systems.
