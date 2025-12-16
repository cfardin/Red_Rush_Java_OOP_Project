# Red Rush 🚗💨

**Red Rush** is a small Java Swing arcade game where you avoid oncoming cars and ambulances, collect points, and try to beat the high score. This project was for my OOP course. The Java OOP concepts is not so clean but it tought me a lot.

---

## 🔧 Features

- Simple keyboard controls (arrow keys) for movement
- Enemy cars and an ambulance with varying speeds
- Persistent high score saved to `highscore.txt`
- Small and easy-to-read codebase
- The `Main` class starts the game by opening the start screen.

## ⚙️ Requirements

- Java JDK (8 or newer)


## 🎮 Controls

- Left Arrow: Move left
- Right Arrow: Move right
- Up Arrow: Move up
- Down Arrow: Move down

Avoid collisions — if you crash, you can restart or return to the start screen.

## 💾 High Score

The game reads and writes the high score from `highscore.txt` in the project root.
If the file does not exist, the game creates it and initializes it to `0`.

## 📁 Project structure (important files)

- `Main.java` — entry point
- `GameStart.java` — start screen UI
- `Game.java` — main game loop and logic
- `RoadPanel.java` — road drawing and dash animation
- `ScoreSystem.java` — load/save high score
- `images/` — images used in the game (cars, UI, etc.)

## 📝 Notes & Tips

- Make sure `images/` and `highscore.txt` are located in the project root when running from terminal.
- The game uses Swing and relies on window focus for key events — click the game area if controls don’t respond.

---

## 📄 License
This project includes a `LICENSE` file in the repository. Check it for usage terms.
