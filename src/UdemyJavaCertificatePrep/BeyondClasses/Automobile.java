package BeyondClasses;

/* If Ford does not extend Automobile => 🔴 ERROR: Invalid permits clause: Ford must directly extend 'Automobile' */
public sealed class Automobile permits Ford, Renault, Fiat { }
