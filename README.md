                                    Countries information application


What:                                                                                                                          
Android application that shows list of countries and details of a country chosen.

Why:                                                                                                                           
As modules of MVP are decoupled with dependency injection (Dagger 2), app gives full flexibility to test the logic (at the moment no logic in this though but in future :blush: ).

Tech used:                                                                                                                     
Architecture: [Model View Presenter](https://en.wikipedia.org/wiki/Model–view–presenter).                         
Network Library: [Retrofit](http://square.github.io/retrofit/)                                                                 
Image Library:  [Universal Image Loader](https://github.com/nostra13/Android-Universal-Image-Loader)                           
Async communication: [Otto Event Bus](http://square.github.io/otto/)                                                           
Dependency Injection: [Dagger 2](https://github.com/codepath/android_guides/wiki/Dependency-Injection-with-Dagger-2)           

Module level diagram that is not drawn so well but helps understanding the stuff better:
![alt txt](https://github.com/gurappa/Countries-Info/blob/master/Countries_mvp.jpg)




Improvements:
1. Two-pane layout for tablets. Fragments are modular and Activities/Fragmens combinations are well placed so should be easy.
2. CoordinatorLayout for details screen.
3. Adding image transition animation from countries screen to details screen.
4. Launching maps app onClick Lat-long text field.
5. Handle no-network scenarios.
6. Currently app uses different retrofit service instances for each URL, one for Countries API, one for Details API. Should use only one instance by just changing the base url.
