
[cfg.pdf](https://github.com/user-attachments/files/20432349/cfg.pdf)

Цикломатската комплексност е 9 добиена преку формулата P+1, каде што P е бројот на предикатни јазли, во кодот P е 8

Every statement Test 1 INPUT allItems = null cardNumber = "1234567890123456"

TEST 2 INPUT allItems = [ Item("D",2,400,0.25) ] cardNumber = "1111222233334444"

TEST 3 INPUT allItems = [ Item(null,1,50,0.0) ] cardNumber = "1234567890123456"

TEST 4 INPUT allItems = [ Item("A",1,500,0.0) ] cardNumber = "1234"

TEST 5 INPUT allItems = [ Item("A",1,10,0.0) ] cardNumber = "1234ABCD5678EFGH"

објаснување со тест 1 се стигнува до RuntimeException("allItems list can't be null!") , тест 2 е итем кој исполнува и попуст и исто така е скап итем па влегува во два if , тест 3 го покрива RuntimeException("Invalid item!") , тест 4 го покрива RuntimeException("Invalid card number!") и исто така влегува во елсе, и тест 5 го покрива RuntimeException("Invalid character in card number!")

5.Multiple Condition
TXX FTX FFT FFF
Ова ги покрива сите варијации на трите променливи
