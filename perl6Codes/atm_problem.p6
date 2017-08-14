#Develop a program that simulates bill delivery (multiple of 5) when a customer cashes out an ATM, giving the smallest number of bills.

sub MAIN() {
    my @bills = (1000, 100, 50, 20, 10, 5);
    my $withdraw = 2255;
    my $moneyBag = @bills.BagHash;

    if $withdraw %% 5 {say "Pas possible!"; return;}
    for @bills -> Int $bill {
        until $withdraw < $bill {
            say $bill;
            $withdraw -= $bill;
            $moneyBag{$bill}++;
        }
    }
    say $moneyBag;
}
