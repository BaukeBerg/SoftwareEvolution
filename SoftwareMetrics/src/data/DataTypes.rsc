module \data::DataTypes

// Clone related types
alias TCloneList = list[TClone];
alias TClone = tuple[int Start, int Size];

alias TCloneClass = set[TClone];
alias TCloneClasses = set[TCloneClass];

alias TClonePairs = list[TClonePair];
alias TClonePair = tuple[TClone First, TClone Second];

alias TCloneInfo = tuple[TCloneList CloneList, TClonePairs ClonePairs];

// String related types
alias THashInfo = tuple[THashMap HashMap, TStringMap StringMap];
alias THashMap = map[int,int];
alias TStringMap = map[str Source, int Encoding];