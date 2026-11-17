#-TODO
##-Experiment with try-with-resources,both in the classes that call the factory,but also within the factory itself.
##-The app was built-out to have Account and its respective balance in a separate table from User entities so that it can be scaled-out to facilitate One User having many Accounts
##-Consolidate DBInitializer to a single function and fit accounts/user init inside. 