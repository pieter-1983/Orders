ALTER table ITEM_QUANTITY_COMBO ADD ORDER_ID INT(10) UNSIGNED;
ALTER table ITEM_QUANTITY_COMBO ADD FOREIGN KEY
                                  (ORDER_ID) REFERENCES
                                  ORDERS (ORDER_ID);
