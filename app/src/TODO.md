#-TODO
##-Experiment with try-with-resources,both in the classes that call the factory,but also within the factory itself.

##-The app was built-out to have Account and its respective balance in a separate table from User entities so that it can be scaled-out to facilitate One User having many Accounts

##-Consolidate DBInitializer to a single function and fit accounts/user init inside. 

##--Use Generated values to create auto-incrementing IDs in the DB instead of using the unique username.

##--Going to opt for querying the DB everytime to verify user-credentials, later-on will change to keep a registeredUser's list in-memory (probably business layer) to cache data and reduce DB operations 

##-- Maybe add an entity that holds both username and password to later pull-from for verifying credentials