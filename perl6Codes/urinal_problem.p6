sub MAIN() {
    #Problem: must resolve the number of available urinals (respecting the vacancy between men) and their positions. 
    my @urinals = < True False False True True False True True False False False True True True False False >;
    #The configuration above has only one available urinal at the last position.

    my $breadCrumb = Nil;
    my Int $counter = 0;
    my @positions = Array.new();
    my $aux = False;

    loop (my $i = 0; $i < @urinals; $i++) {
        if @urinals[$i+1].defined && @urinals[$i+1] eq "True" {
            $aux = True;
        }

        if @urinals[$i-1].defined && @urinals[$i-1] eq "True" {
            $aux = True;
           }
        
        if (@urinals[$i] eq "False" && !$aux) {
            $counter++;
            @positions.append($i);
        }
        $aux = False;
    }
    say $counter;
    say @positions;

}