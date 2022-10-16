# Funksjonelle algoritmer og datastrukturer, ish


## Oppgaver: Innhold og forslag til rekkefølge 
* List - vanlige rekursive lenkelister
* NonEmpty - non-empty lister
* Api - funksjoner i Map-apiet og algebraiske ligninger

Kan åpenbart gjøres i rekkefølgen man selv velger også.

### Oppgaver er som regel å fylle inn `error "todo"` med noe vettugt


## Bygg, kjøring og testing

### Bygg: `cabal build`
### Bygg og kjør alle testene: `cabal run`
### Tester
Testene ligger i main-funksjonene til hver fil
og også en main-funksjon i Main.hs som kjører alle testene.

### Repl : `cabal repl`

### Deamon som kjører alle tester: `ghcid -r`
### Deamon som kjører spesifikke tester: `ghcid --test=NonEmpty.main` f.eks.

