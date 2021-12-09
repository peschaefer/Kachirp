Kachirp

Kachirp is a jokingly passive agressive trivia game that pulls data from https://trivia.willfry.co.uk

To use this program in the GUI, run it through the gradle sidebar under the "application" menu. Once running, select vanilla game to play with random questions from chosen categories (These are retrived from the API mentioned above). Select create custom question bank to create your own set of questions. Select custom game to play a game of trivia with a user created custom question bank. To exit, simply hit the exit button in the top right corner of the window.

The game can also be played in the command line.  This is done by running the main method in the ConsoleExclusives package.  This version of the game is more sassy and less flashy with all the same functionality.

Warnings:
When running tests individually, some print the following in the console:
org.junit.platform.launcher.core.EngineDiscoveryOrchestrator lambda$logTestDescriptorExclusionReasons$7
INFO: 0 containers and 7 tests were Method or class mismatch

This has no impact on the test results and can be disregarded.
