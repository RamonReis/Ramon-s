sub MAIN() {
    my @sequence = <100 101 102 103 104 105 110 111 113 114 115 150>;
    my @sequences = [];
    my @seq;
    my $bc;

    for @sequence -> $item {
        if @seq == 0 {
            @seq.append($item);
            $bc = $item;
        } else {
            say @seq;
            if ($item == $bc+1) {
                @seq.append($item);
                $bc = $item;
            } else {
                @sequences.append{@seq};
                @seq := Array.new().append($item);
                $bc = $item;
            }
        }
    }
    say @sequences;
}
