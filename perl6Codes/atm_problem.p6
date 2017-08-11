#Develop a program that simulates bill delivery (multiple of 5) when a customer cashes out an ATM, giving the smallest number of bills.

sub MAIN() {
    my @bills = (100, 50, 20, 10, 5);
    my $withdraw = 875;
    my @moneyBag = Array.new();

    if $withdraw %5 != 0 {say "Pas possible!"; return;}
    for @bills -> Int $bill {
        until $withdraw < $bill {
            $withdraw -= $bill;
            @moneyBag.append($bill);
        }
    }
    say @moneyBag.Bag.sort;
}