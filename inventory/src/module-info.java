module inventory {
    requires transitive bookapi;    /* if some other module requires inventory, it automatically gets access to bookapi */
    exports com.inventory;          /* in order for com.inventory to be available in other modules */
    //opens com.inventory to reports; /* makes com.inventory available to module reports in the runtime */
}