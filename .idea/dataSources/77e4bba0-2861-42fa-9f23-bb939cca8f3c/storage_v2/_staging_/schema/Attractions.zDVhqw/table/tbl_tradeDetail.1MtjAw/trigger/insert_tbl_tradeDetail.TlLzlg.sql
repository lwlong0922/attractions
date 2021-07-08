create definer = a123456@`%` trigger insert_tbl_tradeDetail
    before insert
    on tbl_tradeDetail
    for each row
BEGIN
    IF (NEW.ticketID<>-1)
    THEN 
        SET NEW.ticketID = 
            (
                SELECT tbl_scenicarea.ticketID 
                FROM tbl_scenicarea 
                WHERE scenicareaID = NEW.ticketID
            );

        UPDATE tbl_scenicarea
        SET numberSold=numberSold+1
        WHERE ticketID = NEW.ticketID;

    ELSEIF (NEW.ticketID=-1) THEN
        SET NEW.ticketID = 1;
    END IF;

END;

