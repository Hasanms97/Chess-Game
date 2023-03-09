# Chess-Game

This project is a console-based Chess game that allows two players to play against each other. This game has been designed and implemented using Object-Oriented Programming principles.

Project structure

The project has been divided into four classes:

ChessGame
This class is the main class of the game. It creates the board, initializes the pieces, and starts the game. It also manages the turns of each player, checks for illegal moves, and determines the winner or draw.

Board
This class represents the Chess board. It has an 8x8 grid of squares, and each square can have a piece on it.

Square
This class represents a single square on the Chess board. It contains the row and column number of the square and the piece that is currently occupying it (if any).

Piece
This class represents a single Chess piece. It contains information about its color, type, and position.

Design Patterns

The following design patterns have been used in this project:

Singleton
The Singleton pattern has been used for the Board class. Since we only need one instance of the board in the game, we have made the constructor private and provided a static getInstance() method that returns the instance of the board.

Factory
The Factory pattern has been used for creating pieces. The PieceFactory class has a static method createPiece() that takes in the color, type, and position of the piece and returns a new instance of the Piece class.

Clean Code Principles

The following Clean Code Principles have been followed in this project:

KISS (Keep It Simple, Stupid)
The code has been kept as simple as possible to make it easy to read and understand. The methods have been kept small and focused, and the naming conventions are clear and concise.

DRY (Don't Repeat Yourself)
The code has been designed to avoid duplication. For example, the Pawn class has a method isValidMove() that can be reused for both black and white pawns, rather than duplicating the code.

YAGNI (You Ain't Gonna Need It)
The code has been designed to avoid adding unnecessary functionality. For example, special moves such as castling, promotion, and En passant have been ignored to keep the code simple and easy to understand.

SOLID Principles

The following SOLID principles have been followed in this project:

Single Responsibility Principle (SRP)
Each class has been designed to have a single responsibility. For example, the Board class is responsible for managing the Chess board, and the Piece class is responsible for managing individual Chess pieces.

Open/Closed Principle (OCP)
The code has been designed to be open for extension but closed for modification. For example, if we need to add new game rules or moves, we can extend the existing classes without modifying their code.

Liskov Substitution Principle (LSP)
The code has been designed to follow the Liskov Substitution Principle. For example, all subclasses of the Piece class can be substituted for the Piece class without affecting the behavior of the program.

Interface Segregation Principle (ISP)
The code has been designed to follow the Interface Segregation Principle. For example, the Piece class only contains methods that are relevant to Chess pieces, and not any other classes.

Dependency Inversion Principle (DIP)
The code has been designed to follow the Dependency Inversion Principle. For example, the ChessGame class depends on the Board class through an interface, rather than directly depending on the Board class.

