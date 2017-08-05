sub MAIN() { 
    #my $p = Pessoa.new;
    #$p.print_p_name;
    my @v1 = <4 3 2 1>;
    my @v2 = <4 3 2 1>;

    my $scalarProduct = 0;

    loop (my $i = 0 ; $i < @v1; $i++) {
        $scalarProduct += @v1[$i] * @v2[$i];
        say $scalarProduct;
    }
    say "Final value is: $scalarProduct";
}