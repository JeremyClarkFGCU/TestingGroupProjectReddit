========================================================================================================
FGCU CEN 4072 - Software Testing - Group Project
========================================================================================================
Peter Ocean
Jeremy Clark

Selenium Automated Web Driver Testing Performed on Reddit

Using:
====================
Java
Selenium
TestNG

Performs Following
====================
1. Log In
2. Search SubReddits
3. Create Post
4. Comment on Existing Post
5. Down/Up Vote Posts
6. Edit Profile
7. Log Out

There are some issues with the Shadow Div Elements in Reddit's HTML that make the results inconsistent. Depending on exactly what path is taken by the user, the underlying code is altered and the test suite may not be able to locate the elements by the ID, xPath, or CSS.
We did not create failsafes or redundant element locating tools as it was beyond the scope of this project. 
