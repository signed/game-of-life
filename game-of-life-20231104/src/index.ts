export type Board = Position[]
type Position = `${number}/${number}`
type Habitat = {
  status: 'lebt' | 'tod'
  nachbarn: number
}

export function tick(board: Board): Board {
  return kandidatenFuerBoard(board)
    .map((kandidat) => ({ kandidat, habitat: bestimmeHabitatFuer(kandidat, board) }))
    .filter((x) => lebtNaechsteRunde(x.habitat))
    .map((habitat) => habitat.kandidat)
}

export const kandidatenFuerBoard = (board: Board) => {
  return entferneDoppelte(board.map(kandidatenFuer).flat())
}

export function entferneDoppelte(positionen: readonly Position[]) {
  return Array.from(new Set<Position>([...positionen]).values())
}

export function bestimmeHabitatFuer(position: Position, board: Position[]): Habitat {
  const nachbarn = koordinatenFuerNachbarn(position).filter((x) => board.includes(x)).length
  const status = board.includes(position) ? 'lebt' : 'tod'
  return {
    status,
    nachbarn,
  }
}

function koordinatenFuerNachbarn(position: Position): Position[] {
  return kandidatenFuer(position).filter((p) => p !== position)
}

export function kandidatenFuer(position: Position): Position[] {
  const { x, y } = nachXY(position)
  const linksX = x - 1
  const rechtsX = x + 1
  const obenY = y - 1
  const untenY = y + 1
  //prettier-ignore
  return [
        `${linksX}/${obenY}`, `${x}/${obenY}`, `${rechtsX}/${obenY}`,
        `${linksX}/${y}`, `${x}/${y}`, `${rechtsX}/${y}`,
        `${linksX}/${untenY}`, `${x}/${untenY}`, `${rechtsX}/${untenY}`,
    ]
}

export function lebtNaechsteRunde(habitat: Habitat) {
  if (habitat.status === 'tod') {
    return habitat.nachbarn === 3
  }
  return habitat.nachbarn === 2 || habitat.nachbarn === 3
}

export function nachXY(position: Position) {
  const teile = position.split('/').map((koordinate) => parseInt(koordinate))
  const x = teile[0]!
  const y = teile[1]!
  return { x, y }
}
