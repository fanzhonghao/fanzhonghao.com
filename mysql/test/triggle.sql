use test;
create TRIGGER first
  after insert on b
  for each row
  as begin
    insert into a
      values(2);
  end;
