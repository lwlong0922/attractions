create
    definer = a123456@`%` procedure Ticket_Sales_By_Day(IN timed date, OUT num int)
BEGIN
    SELECT remain INTO num FROM Attractions.tbl_ticketremain WHERE dateTime=timed;
END;

