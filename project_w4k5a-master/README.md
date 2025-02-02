#Closet Manager Project

###What will this application do?

I am designing this application to act as a *virtual* representation of my **closet**. It will be able to store all of 
my clothing items including:
- Shirts
- Pants
- Hoodies
- Sweaters
- Jackets
- Shorts
- Shoes

Each clothing item will also include its own **properties** such as:
- Name
- Colour
- Thickness
- Material
- Comfortability

As the project continues to develop, I am hoping to implement more **useful** features to the application that I could 
use on a daily basis. These include being able to generate an outfit for me based on the conditions that I give, let me 
know which items I need to wash, tell me which items I wear the most and which I wear the least, etc. Of course, as new 
ideas come, I will continue to update the application and improve its usability.

###Who will use it?

I am mainly designing this application for myself to use, and therefore will implement features that would be most 
useful to myself. However, I'm sure that many features that I would find useful would also be useful to a large group 
of others, so this application could be used by anyone who has a closet with a variety of clothing items.

###Why is this project of interest to me?

This project is of interest to me because I feel like I never have a great idea of my closet situation. There are some 
items which I feel like I wear too often or too little, but I never know for sure because I don't record how many times 
I wear them. I also struggle with trying to create outfits, and often feel like I stick to the same few outfits while 
not making use of the tens to hundreds of viable outfits I am missing out on simply because I haven't discovered the 
right combination yet. Overall, this application could help me to improve my clothing situation and enhance my daily 
life.

###User stories

- As a user, I want to be able to add a new item to my closet
- As a user, I want to be able to remove an item from my closet
- As a user, I want to be able to know how many items are in my closet
- As a user, I want to be able to view the items in my closet

- As a user, I want to be able to save my closet to file
- As a user, I want to be able to load my closet from file

###Phase 4: Task 2

Here is a log of a representative sample of events that could occur while this program is running:

Fri Apr 01 09:26:18 PDT 2022  
Added T-shirt to your closet.

Fri Apr 01 09:26:40 PDT 2022  
Added Hoodie to your closet.

Fri Apr 01 09:26:47 PDT 2022  
Removed Joggers from your closet.

###Phase 4: Task 3

Currently in the ClothingItem class, there is a field called type which can be either a "Top", "Bottom", or "Shoe". If 
I had more time, I could convert the type of that field from a String to an Enumeration class that I would make myself. 
Another option that I could do is to turn ClothingItem into an abstract class, and make three subclasses named Top, 
Bottom, and Shoe which all extend ClothingItem. Other than that, there is no refactoring I would do with the current 
state of the application.