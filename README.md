# WhoWantsToBeAMillionaire

## Simple command line game created after the popular TV show "Who Wants To Be a Millionaire".

## There are two versions of this game :
1. A version that uses an api which is consumed in order to get the questions.
2. A version that uses file reading and gets questions from csv files.

## 1 API Version :
Questions are provided by consuming an api, which response is encoded in base64. The response is parsed using JsonSimple and converted to questions.
This versions is making use of multithreading and the api response is handled in parallel while the introduction of the game occurs. In this way, the player doesn't have to wait. 

## 2 File Reading Version :
Simple file reading from CSV files and using JsonSimple to create the questions.
